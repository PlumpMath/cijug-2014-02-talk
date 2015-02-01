(ns java-interop.core)

(defn -main []
  (println (.toLowerCase (.toString (new java.lang.StringBuffer "Hello, World!")))))
