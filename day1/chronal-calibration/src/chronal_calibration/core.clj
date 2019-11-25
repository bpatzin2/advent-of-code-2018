(ns chronal-calibration.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn parse-int [s]
  (. Integer (parseInt (re-find #"\A-?\d+" (str/replace s #"\+" "")))))    

(defn split_string [numbers_string]
  (str/split numbers_string #", "))

(defn string-to-int-vector [numbers_string] 
  (map parse-int (split_string numbers_string)))

(defn sum_comma_separated_numbers [numbers_string]
  (reduce + (string-to-int-vector numbers_string)))

(defn -main []
  (sum_comma_separated_numbers "-1, 1, 0"))
