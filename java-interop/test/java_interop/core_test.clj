(ns java-interop.core-test
  (:require [clojure.test :refer :all]
            [java-interop.core :refer :all]))

(deftest output
  (testing "is always Hello, World!"
    (is (= "hello, world!\n" (with-out-str (-main))))))

(deftest creates-hello-world-from-pieces
  (testing "is always Hello, World!"
    (is (= "Hello, World!" (make-hello2)))))

(deftest metric-spaces
  (testing "cartesian distances are familiar"
    (are [expected a b] (= expected (distance (->TwoDCartesian a) (->TwoDCartesian b)))
         5  [3 4] [0 0]
         0  [5 5] [5 5]
         13 [0 0] [5 12]
         13 [0 0] [12 5]
         13 [10 4] [15 -8]
         5  [1 3 4] [1 0 0]
         10 [1 -3 -4] [1 3 4]
         2  [0 0 0 0] [1 1 1 1])))
