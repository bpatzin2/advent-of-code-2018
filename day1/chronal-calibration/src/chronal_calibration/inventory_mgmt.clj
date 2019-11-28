(ns chronal-calibration.inventory-mgmt
  (:gen-class))

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
