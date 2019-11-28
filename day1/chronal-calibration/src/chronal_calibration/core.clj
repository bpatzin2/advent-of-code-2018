(ns chronal-calibration.core
  (:gen-class)
  (:require [chronal-calibration.chronal-calibration :as cc]
            [chronal-calibration.file-input :as input]))

(defn day1pt1 []
  (cc/sum_comma_separated_numbers (input/gen-csv)))

(defn day1pt2 []
  (cc/first-dup-in-rolling-sum (input/gen-csv)))
