(ns chronal-calibration.chronal-calibration
  (:gen-class)
  (:require [clojure.string :as str]))

(defn parse-int [s]
  (. Integer (parseInt (re-find #"\A-?\d+" (str/replace s #"\+" "")))))

(defn split-string [numbers_string]
  (str/split numbers_string #", "))

(defn map-string-to-int-vector [numbers_string]
  (map parse-int (split-string numbers_string)))

(defn sum_comma_separated_numbers [numbers_string]
  (reduce + (map-string-to-int-vector numbers_string)))

(defn reduced-dup-val-or-append [vec, val]
  (if (contains? vec val)
    (reduced val)
    (conj vec val)))

(defn rolling-sum [int-seq]
  (reductions + 0 (cycle int-seq)))

(defn rolling-sum-from-string [numbers_string]
  (rolling-sum (map-string-to-int-vector numbers_string)))

(defn first-dup-in-rolling-sum [numbers_string]
  (reduce reduced-dup-val-or-append #{} (rolling-sum-from-string numbers_string)))
