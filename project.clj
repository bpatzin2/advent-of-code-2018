(defproject chronal-calibration "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/math.combinatorics "0.1.6"]
                 [clj-fuzzy "0.4.1"]]
  :aot [chronal-calibration.core]
  :main chronal-calibration.core
  :profiles {:dev {:dependencies [[speclj "3.3.0"]]}}
  :plugins [[speclj "3.3.0"]]
  :test-paths ["spec"])
  
  
  

  
