(ns chronal-calibration.inventory-mgmt
  (:gen-class)
  (:require [clj-fuzzy.metrics :as fuzzy]
            [clojure.math.combinatorics :as combo]))

(defn any-value-exact-count? [s, n]
  (contains? (set (vals (frequencies s))) n))

(defn any-value-twice? [s]
  (any-value-exact-count? s 2))

(defn any-value-thrice? [s]
  (any-value-exact-count? s 3))

(defn count-with-freq-2 [strings]
  (count (filter any-value-twice? strings)))

(defn count-with-freq-3 [strings]
  (count (filter any-value-thrice? strings)))

(defn checksum [strings]
  (* (count-with-freq-2 strings) (count-with-freq-3 strings)))

(defn is-hamming-1 [string-pair]
  (= 1 (fuzzy/hamming (first string-pair) (second string-pair))))

(defn hamming-dist-1 [strings]
  (set (flatten (filter is-hamming-1 (combo/cartesian-product strings strings)))))

(defn matching-letters [s1 s2]
  (map 
   first 
   (filter
    #(= (first %) (second %))
    (partition 2 (interleave s1 s2)))))

(defn common-letters-of-ham1-strings [strings]
  (let [pair (hamming-dist-1 strings)
        s1 (first pair)
        s2 (second pair)]
      (clojure.string/join "" (matching-letters s1 s2))))
