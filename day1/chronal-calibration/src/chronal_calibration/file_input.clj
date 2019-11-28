(ns chronal-calibration.file-input
  (:gen-class)
  (:require [clojure.string :as str]))

(defn day1-input-as-string [] (slurp "day1_input.txt"))

(defn day1-tmp-csv [] (str/replace (day1-input-as-string) #"\n" ", "))

(defn day1-input-csv [] (subs (day1-tmp-csv) 0 (- (count (day1-tmp-csv)) 2)))
