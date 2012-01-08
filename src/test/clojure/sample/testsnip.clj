(ns sample.testsnip
  (:use [clojure.test :only (deftest is run-tests)])
  (:require [sample.snippets :as sample]))

(deftest test-euler6
  (is (= 2640 (sample/euler6 10)))
  (is (= 41230 (sample/euler6 20))))
