(ns java-interop.core)

(defn make-hello []
  (let [sb (java.lang.StringBuilder.)]
    (.append sb "Hello")
    (.append sb ",")
    (.append sb " ")
    (.append sb "World")
    (.append sb "!")
    sb))

(defn -main []
  (println (.toLowerCase (.toString (make-hello)))))
