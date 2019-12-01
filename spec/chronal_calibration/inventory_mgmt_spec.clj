(ns chronal-calibration.inventory-mgmt-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.inventory-mgmt :refer :all]))

(describe "count-with-freq-2"
          (it "works for test input"
              (should= 2 (count-with-freq-2 ["aa", "aabb", "abc", "aaa"]))))

          
(describe "count-with-freq-3"
          (it "works for test input"
              (should= 2 (count-with-freq-3 ["aaa", "aaabbb", "abc", "bbbb"]))))

(describe "checksum"
          (it "works for test input"
              (should= 4 (checksum ["aa", "aaa", "aabbb", "abc"]))))

(run-specs)