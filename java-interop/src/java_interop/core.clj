(ns java-interop.core
  (:import com.cwfreeman.StringEngine
           com.cwfreeman.StringWorker)
  (:require [clojure.math.numeric-tower :refer [sqrt expt]]))

(defprotocol MetricSpacePoint
  (distance [this other]))
(defrecord TwoDCartesian [x y]
  MetricSpacePoint
  (distance [this other] (sqrt
                          (+
                           (expt (- x (:x other)) 2)
                           (expt (- y (:y other)) 2)))))

(defrecord IdentityStringWorker []
  com.cwfreeman.StringWorker
  (map [this x] x)
  (reduce [this xs] (apply str xs)))

(defn make-hello2 []
  (let [engine (com.cwfreeman.StringEngine. (into-array String ["Hello" "," " " "World" "!"]))]
    (.work engine IdentityStringWorker)))

(defn make-hello []
  (doto (java.lang.StringBuilder.)
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!")))

(defn -main []
  (println (-> (make-hello) .toString .toLowerCase)))
