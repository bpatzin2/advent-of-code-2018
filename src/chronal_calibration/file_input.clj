(ns chronal-calibration.file-input
  (:gen-class)
  (:require [clojure.string :as str]))

(defn day1-input-as-string [] (slurp "day1_input.txt"))

(defn day1-tmp-csv [] (str/replace (day1-input-as-string) #"\n" ", "))

(defn day1-input-csv [] (subs (day1-tmp-csv) 0 (- (count (day1-tmp-csv)) 2)))

(defn day2-input-list [] (str/split (slurp "day2_input.txt"), #"\n"))

(defn square-string [full-str] 
  (subs full-str (+ 2 (str/index-of full-str "@"))))

(defn day3-input-list []
  (str/split (slurp "day3_input.txt"), #"\n"))

(defn start-point [square-string]
  (vec (map #(Integer/parseInt %) (str/split (subs square-string 0 (str/index-of square-string ":")) #","))))

(defn square-size [square-string]
  (vec (map #(Integer/parseInt %) (str/split (subs square-string (+ 2 (str/index-of square-string ":"))) #"x"))))

(defn square-obj [square-string]
  [(start-point square-string) (square-size square-string)])

(defn day3-input [] 
  (let [square-strings (map square-string (day3-input-list))]
    (map square-obj square-strings)))
