(ns chronal-calibration.file-input
  (:gen-class)
  (:require [clojure.string :as str]))

(defn input-as-string [] (slurp "day1_input.txt"))

(defn tmp-csv [] (str/replace (input-as-string) #"\n" ", "))

(defn gen-csv [] (subs (tmp-csv) 0 (- (count (tmp-csv)) 2)))
