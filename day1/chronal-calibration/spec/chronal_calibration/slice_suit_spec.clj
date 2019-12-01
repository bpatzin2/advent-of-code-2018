(ns chronal-calibration.inventory-mgmt-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.slice-suit :refer :all]))

(describe "expand-all"
          (it "works for test input"
              (should= [[0 0]] (expand-all [[[0, 0] [1, 1]]]))
              (should= [[0 0] [1 0]] (expand-all [[[0, 0] [2, 1]]]))
              (should= [[0 0] [0 1] [0 2]] (expand-all [[[0, 0] [1, 3]]]))
              (should= [[0 0] [0 0]] (expand-all [[[0, 0] [1, 1]] 
                                                  [[0, 0] [1, 1]]]))))

(run-specs)