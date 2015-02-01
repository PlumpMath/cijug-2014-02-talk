(ns java-interop.core
  (:import com.cwfreeman.StringEngine
           com.cwfreeman.StringWorker))

(defn make-hello2 []
  (let [engine (com.cwfreeman.StringEngine. (into-array String ["Hello" "," " " "World" "!"]))]
    (.work engine ???)))

(defn make-hello []
  (doto (java.lang.StringBuilder.)
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!")))

(defn -main []
  (println (-> (make-hello) .toString .toLowerCase)))
