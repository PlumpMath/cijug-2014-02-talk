(ns java-interop.core-test
  (:require [clojure.test :refer :all]
            [java-interop.core :refer :all]))

(deftest output
  (testing "is always Hello, World!"
    (is (= "Hello, World!\n" (-main)))))
