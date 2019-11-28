(ns chronal-calibration.core-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.file-input :refer :all]
            [chronal-calibration.core :refer :all]))

(describe "sum_comma_separated_numbers"
          (it "works for test input"
              (should= 3 (sum_comma_separated_numbers "+1, +1, +1"))
              (should= 0 (sum_comma_separated_numbers "+1, +1, -2"))
              (should= -6 (sum_comma_separated_numbers "-1, -2, -3")))
          (it "works for real input"
              (should= 569 (sum_comma_separated_numbers (gen-csv)))))

(describe "first-dup-in-rolling-sum"
          (it "works for test input"
              (should= 0 (first-dup-in-rolling-sum "+1, -1"))
              (should= 10 (first-dup-in-rolling-sum "+3, +3, +4, -2, -4"))
              (should= 5 (first-dup-in-rolling-sum "-6, +3, +8, +5, -6"))
              (should= 14 (first-dup-in-rolling-sum "+7, +7, -2, -7, -4")))
          (it "works for real input"
              (should= 77666 (first-dup-in-rolling-sum (gen-csv)))))

(run-specs)