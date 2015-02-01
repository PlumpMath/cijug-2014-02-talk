(ns java-interop.core)

(defn make-hello []
  (let [sb (java.lang.StringBuilder. "Hello, World!")]
    sb))

(defn -main []
  (println (.toLowerCase (.toString (make-hello)))))
