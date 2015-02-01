(ns java-interop.core)

(defn make-hello []
  (let [sb (java.lang.StringBuilder.)]
    (doto sb
      (.append "Hello")
      (.append ",")
      (.append " ")
      (.append "World")
      (.append "!"))
    sb))

(defn -main []
  (println (.toLowerCase (.toString (make-hello)))))
