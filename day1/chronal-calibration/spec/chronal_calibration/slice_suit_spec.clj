(ns chronal-calibration.inventory-mgmt-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.slice-suit :refer :all]))

(describe "all-squares"
          (it "works for test input"
              (should= [#{[0 0]}] (overlapping-squares [[[0, 0] [1, 1]]]))
              (should= [ #{[0 0] [1 0]}] (overlapping-squares [[[0, 0] [2, 1]]]))
              (should= [#{[0 0] [0 1] [0 2]}] (overlapping-squares [[[0, 0] [1, 3]]]))
              (should= [#{[0 0]} #{[0 0]}] (overlapping-squares [[[0, 0] [1, 1]] 
                                                                 [[0, 0] [1, 1]]]))))

(run-specs)