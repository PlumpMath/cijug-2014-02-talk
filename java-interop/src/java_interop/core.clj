(ns java-interop.core
  (:import com.cwfreeman.StringEngine
           com.cwfreeman.StringWorker))

(defn make-worker []
  (proxy [com.cwfreeman.StringWorker] []
    (map [x] x)
    (reduce [xs] (apply str xs))))

(defn make-hello2 []
  (let [engine (com.cwfreeman.StringEngine. (into-array String ["Hello" "," " " "World" "!"]))]
    (.work engine (make-worker))))

(defn make-hello []
  (doto (java.lang.StringBuilder.)
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!")))

(defn -main []
  (println (-> (make-hello) .toString .toLowerCase)))
