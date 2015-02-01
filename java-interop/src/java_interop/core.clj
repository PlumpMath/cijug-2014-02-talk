(ns java-interop.core
  (:import com.cwfreeman.StringEngine
           com.cwfreeman.StringWorker))

(gen-class
 :name java_interop.worker.IdentityStringWorker
 :implements [com.cwfreeman.StringWorker]
 :prefix "worker-")

(defn worker-map [this x] x)
(defn worker-reduce [this xs] (apply str xs))

(defn make-hello2 []
  (let [engine (com.cwfreeman.StringEngine. (into-array String ["Hello" "," " " "World" "!"]))]
    (.work engine java_interop.worker.IdentityStringWorker)))

(defn make-hello []
  (doto (java.lang.StringBuilder.)
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!")))

(defn -main []
  (println (-> (make-hello) .toString .toLowerCase)))
