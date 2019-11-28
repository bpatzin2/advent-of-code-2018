(ns chronal-calibration.core
  (:gen-class)
  (:require [clojure.string :as str]
            [chronal-calibration.chronal-calibration :as cc]
            [chronal-calibration.file-input :refer :all]))

(defn day1pt1 []
  (cc/sum_comma_separated_numbers (gen-csv)))

(defn day1pt2 []
  (cc/first-dup-in-rolling-sum (gen-csv)))
