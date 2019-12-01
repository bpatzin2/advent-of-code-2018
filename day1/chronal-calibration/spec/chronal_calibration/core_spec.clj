(ns chronal-calibration.core-spec
  (:require [speclj.core :refer :all]
            [chronal-calibration.file-input :refer :all]
            [chronal-calibration.core :refer :all]))

(describe "day1pt1"
          (it "works for real input"
              (should= 569 (day1pt1))))

(describe "day1pt2"
          (it "works for real input"
              (should= 77666 (day1pt2))))

(describe "day2pt1"
          (it "works for real input"
              (should= 5727 (day2pt1))))

(describe "day3pt1"
          (it "works for real input"
              (should= 121259 (day3pt1))))

(run-specs)