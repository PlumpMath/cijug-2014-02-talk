(ns java-interop.core)

(defn make-hello []
  (let [sb (java.lang.StringBuilder.)]
    (.append sb "Hello, World!")
    sb))

(defn -main []
  (println (.toLowerCase (.toString (make-hello)))))
