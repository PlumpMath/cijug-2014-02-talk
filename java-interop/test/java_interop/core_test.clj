(ns java-interop.core-test
  (:require [clojure.test :refer :all]
            [java-interop.core :refer :all]))

(deftest output
  (testing "is always Hello, World!"
    (is (= "hello, world!\n" (with-out-str (-main))))))

(deftest creates-hello-world-from-pieces
  (testing "is always Hello, World!"
    (is (= "Hello, World!" (make-hello2)))))

(defn my-test-fixture [f]
  (prn "Before the test")
  (f)
  (prn "After the test"))

(defn my-suite-fixture [f]
  (prn "Before the suite")
  (f)
  (prn "After the suite"))

(use-fixtures :each my-test-fixture)
(use-fixtures :once my-suite-fixture)

(deftest simple-equality
  (is (= true true)))

(deftest redefing-stuff-is-fun
  (with-redefs [clojure.core/prn (fn [& xs] 5)]
    (is (= 5 (prn "hello, world!")))))
