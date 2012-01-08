(ns sample.snippets
  (:use [clojure.contrib.duck-streams :only (read-lines)]))

(defn euler6 [n]
  (let [nums (range 1 (inc n))
        sum (reduce + nums)
        sum-sq (reduce + (map #(* % %) nums))]
    (- (* sum sum) sum-sq)))

(defn execute [& args]
  (let [argstr (reduce str (interleave args (iterate str " ")))
        process (.exec (Runtime/getRuntime) argstr)]
    (do 
      (.waitFor  process)
      {:out (read-lines (.getInputStream process))
       :err (read-lines (.getErrorStream process))})))

(execute "java" "-version")

(let [m1 {:a 1 :b 2 :c 3}
      m2 {"a" 11 "b" 22 "c" 33}
      {:keys [a]} m1 
      {:strs [b]} m2]
  (println (str "a=" a ", b=" b)))

;; list destructuring

(let [[a b & more] [1 2 3 4 5]] [b more])