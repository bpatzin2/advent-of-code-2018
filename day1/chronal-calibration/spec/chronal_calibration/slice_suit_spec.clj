(ns chronal-calibration.inventory-mgmt-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.slice-suit :refer :all]))

(describe "expand-all"
          (it "works for test input"
              (should= [[0 0]] (expand-all [[[0, 0] [1, 1]]]))
              (should= [[0 0] [1 0]] (expand-all [[[0, 0] [2, 1]]]))
              (should= [[0 0] [0 1] [0 2]] (expand-all [[[0, 0] [1, 3]]]))
              (should= [[0 0] [0 0]] 
                       (expand-all [[[0, 0] [1, 1]] 
                                    [[0, 0] [1, 1]]]))
              (should= [[0 0] [0 1] [1 0] [1 1] [2 0] [2 1] [1 1] [1 2] [2 1] [2 2]] 
                       (expand-all [[[0, 0] [3, 2]]
                                    [[1, 1] [2, 2]]]))))

(describe "overlapping-squares"
          (it "works for test input"
              (should= #{} (overlapping-squares [[[0, 0] [1, 1]]]))
              (should= #{[0 0]}
                       (overlapping-squares [[[0, 0] [1, 1]]
                                             [[0, 0] [1, 1]]]))
              (should= #{[1 1] [2 1]}
                       (overlapping-squares [[[0, 0] [3, 2]]
                                             [[1, 1] [2, 2]]]))))

; #1 @ 1,3: 4x4
; #2 @ 3,1: 4x4
; #3 @ 5,5: 2x2
(describe "overlapping-squares"
          (it "works for official test input"
              (should= #{[3 3] [3 4] [4 3] [4 4]}
                       (overlapping-squares [[[1, 3] [4, 4]]
                                             [[3, 1] [4, 4]]
                                             [[5, 5] [2, 2]]]))))

(run-specs)