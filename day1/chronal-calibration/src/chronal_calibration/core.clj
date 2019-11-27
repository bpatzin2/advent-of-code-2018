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

(defn rolling-sum [vec, val] 
  (conj vec (+ (last vec) val)))

(defn reduced-dup-val-or-append [vec, val]
  (if (contains? vec val)
    (reduced val) 
    (conj vec val)))

(defn rolling_sum_comma_separated_numbers [numbers_string]
  (reduce rolling-sum [0] (string-to-int-vector numbers_string)))

(defn ever-growing-cycles [numbers_string]
  (map #(str/join ", " %1) (reductions conj [numbers_string] (repeat numbers_string))))

(defn ever-growing-rolling-sums [numbers_string]
  (map rolling_sum_comma_separated_numbers (ever-growing-cycles numbers_string)))

(defn reduce-to-val-or-nil [vec]
  (reduce reduced-dup-val-or-append #{} vec))

(defn first-repeated-sum-or-rolling-sums [numbers_string]
  (map reduce-to-val-or-nil (ever-growing-rolling-sums numbers_string)))

(defn val-or-nil [_, val]
  (if (coll? val) (constantly nil) (reduced val)))

(defn first-dup-in-rolling-sum [numbers_string]
  (reduce val-or-nil [] (first-repeated-sum-or-rolling-sums numbers_string)))

(defn -main []
  (sum_comma_separated_numbers "-1, 1, 0"))
