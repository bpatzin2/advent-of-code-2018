(ns chronal-calibration.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn parse-int [s]
  (. Integer (parseInt (re-find #"\A-?\d+" (str/replace s #"\+" "")))))    

(defn split_string [numbers_string]
  (str/split numbers_string #", "))

(defn sum_comma_separated_numbers [numbers_string]
  (reduce + (map parse-int (split_string numbers_string))))

(defn -main []
  (sum_comma_separated_numbers "-1, 1, 0"))
