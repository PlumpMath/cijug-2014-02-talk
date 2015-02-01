(ns java-interop.core-test
  (:require [clojure.test :refer :all]
            [java-interop.core :refer :all]))

(deftest output
  (testing "is always Hello, World!"
    (is (= "hello, world!\n" (with-out-str (-main))))))

(deftest creates-hello-world-from-pieces
  (testing "is always Hello, World!"
    (is (= "Hello, World!" (make-hello2)))))

