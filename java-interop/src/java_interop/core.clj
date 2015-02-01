(ns java-interop.core)

(defn make-hello []
  (doto (java.lang.StringBuilder.)
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!")))

(defn -main []
  (println (-> (make-hello) .toString .toLowerCase)))
