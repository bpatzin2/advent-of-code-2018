(ns chronal-calibration.core
  (:gen-class)
  (:require [chronal-calibration.chronal-calibration :as cc]
            [chronal-calibration.inventory-mgmt :as im]
            [chronal-calibration.slice-suit :as ss]
            [chronal-calibration.file-input :as input]))

(defn day1pt1 []
  (cc/sum_comma_separated_numbers (input/day1-input-csv)))

(defn day1pt2 []
  (cc/first-dup-in-rolling-sum (input/day1-input-csv)))

(defn day2pt1 []
  (im/checksum (input/day2-input-list)))

(defn day2pt2 []
  (im/common-letters-of-ham1-strings (input/day2-input-list)))

(defn day3pt1 []
  (count (ss/overlapping-squares (input/day3-input))))
