(ns chronal-calibration.core-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.core :refer :all]))

(describe "sum_comma_separated_numbers"

          (it "works"
              (should= 3 (sum_comma_separated_numbers "+1, +1, +1"))
              (should= 0 (sum_comma_separated_numbers "+1, +1, -2"))
              (should= -6 (sum_comma_separated_numbers "-1, -2, -3"))))

(describe "rolling_sum_comma_separated_numbers"

          (it "works"
              (should= [0, 1, 2, 3] (rolling_sum_comma_separated_numbers "+1, +1, +1"))
              (should= [0, 1, 2, 0] (rolling_sum_comma_separated_numbers "+1, +1, -2"))
              (should= [0, -1, -3, -6] (rolling_sum_comma_separated_numbers "-1, -2, -3"))))

(describe "first-dup-in-rolling-sum"

          (it "works"
              (should= 0 (first-dup-in-rolling-sum "+1, -1"))
              (should= 10 (first-dup-in-rolling-sum "+3, +3, +4, -2, -4"))
              (should= 5 (first-dup-in-rolling-sum "-6, +3, +8, +5, -6"))
              (should= 14 (first-dup-in-rolling-sum "+7, +7, -2, -7, -4"))))


(run-specs)