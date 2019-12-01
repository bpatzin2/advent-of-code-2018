(ns chronal-calibration.slice-suit
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]))

(defn square [a b offset-pair] 
  [(+ a (first offset-pair)) (+ b (second offset-pair))])

(defn range-cart-product [x y]
  (combo/cartesian-product (range 0 x) (range 0 y)))

(defn expand [rectangle]
  (let [a ((rectangle 0) 0) 
        b ((rectangle 0) 1)
        width ((rectangle 1) 0)
        height ((rectangle 1) 1)]
    (map #(square a b %) (range-cart-product width height))))

(defn expand-all [rectangles] 
  (mapcat expand rectangles))

