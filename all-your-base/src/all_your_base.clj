(ns all-your-base
  (:require [clojure.math :as m]))

(defn convert [] ;; <- arglist goes here
  ;; your code goes here
  )


(defn to-base-10
  [num-list base]
  (let [comb (mapv #(vector (m/pow base %2) %1) (reverse num-list) (range))
        base-ten (->> comb
                      (map #(* (first %) (second %)))
                      (reduce +)
                      int)]
    base-ten))

(defn from-base-10
  [num to-base]
  (let [quot-list ()]))

(to-base-10 '(2 4 3 1) 5)

(quot 2342 10)

(loop [quot 123
       remains '()]
  (if (< (rem quot 2) 2)))

(cons   1 '(2))