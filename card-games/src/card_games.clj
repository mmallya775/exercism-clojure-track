(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (+ n 1) (+ n 2)))

(defn concat-rounds
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (if (some #(= % n) l)
    true
    false))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (let [sum-of-list (reduce + hand)
        counter     (count    hand)
        average-of-list (float (/ sum-of-list counter))]
    average-of-list))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [first-and-last (float (/ (+ (first hand) (last hand)) 2))
        size (count hand)
        hand-average (card-average hand)
        median (if (odd? size)
                 (float (nth hand (/ size 2)))
                 (float (/ (+ (nth hand (dec (quot size 2))) (nth hand (quot size 2))) 2)))]
    (cond
      (= first-and-last hand-average) true
      (= median hand-average) true
      :else false)))


(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [sum-even-indexes (->> hand
                              (zipmap (range))
                              (filter (fn [[k _]] (even? k)))
                              (map second)
                              (reduce +))
        count-even-indexes (->> hand
                                (zipmap (range))
                                (filter (fn [[k _]] (even? k)))
                                (map first)
                                count)
        sum-odd-indexes  (->> hand
                              (zipmap (range))
                              (filter (fn [[k _]] (odd? k)))
                              (map second)
                              (reduce +))
        count-odd-indexes (->> hand
                               (zipmap (range))
                               (filter (fn [[k _]] (odd? k)))
                               (map first)
                               count)]
    (cond
      (= (/ sum-even-indexes count-even-indexes) (/ sum-odd-indexes count-odd-indexes)) true
      :else false)))


(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= (last hand) 11)
    (concat (reverse (rest (reverse hand))) '(22))
    hand))


