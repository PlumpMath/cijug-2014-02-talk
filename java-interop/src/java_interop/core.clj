(ns java-interop.core)

(defn make-hello []
  (java.lang.StringBuilder. "Hello, World!"))

(defn -main []
  (println (.toLowerCase (.toString (make-hello)))))
