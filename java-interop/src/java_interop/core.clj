(ns java-interop.core)

(defn -main []
  (println (.toLowerCase (.toString (java.lang.StringBuilder. "Hello, World!")))))
