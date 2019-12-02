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

(describe "hamming-dist-1"
          (it "works for test input"
              (should= #{"aaa" "aab"} (hamming-dist-1 ["aaa" "bbb" "aab"]))))

(describe "common-letters-of-ham1-strings"
          (it "works for test input"
              (should= "aa" (common-letters-of-ham1-strings ["aaa" "bbb" "aab"]))
              (should= "abcdf" (common-letters-of-ham1-strings ["abcdef" "abcdXf" "abcXYZ"]))
              (should= "fgij" (common-letters-of-ham1-strings ["abcde"
                                                                "fghij"
                                                                "klmno"
                                                                "pqrst"
                                                                "fguij"
                                                                "axcye"
                                                                "wvxyz"]))))

(run-specs)