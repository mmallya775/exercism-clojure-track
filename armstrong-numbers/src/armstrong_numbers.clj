(ns armstrong-numbers)

(defn nums-to-vec
  [num]
  (loop [i num
         res []]
    (if (< i 10)
      (conj res i)
      (recur (quot i 10) (conj res (rem i 10))))))

(defn exp [a m]
  (reduce * (repeat m a)))

(defn armstrong?
  "Returns true if the given number is an Armstrong number; otherwise, returns false"
  [num]
  (let [res (nums-to-vec num)
        counter (count res)
        add-nums-powers  (->> (map #(exp % counter) res)
                              (reduce +))]
    (if (= num add-nums-powers)
      true
      false)))
