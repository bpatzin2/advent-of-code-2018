(ns chronal-calibration.core-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.core :refer :all]))

(describe "sum_comma_separated_numbers"

          (it "works"
              (should= 3 (sum_comma_separated_numbers "+1, +1, +1"))
              (should= 0 (sum_comma_separated_numbers "+1, +1, -2"))
              (should= -6 (sum_comma_separated_numbers "-1, -2, -3"))))

(run-specs)