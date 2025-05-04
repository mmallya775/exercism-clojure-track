(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[f _] deck]
    f))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ s _] deck]
    s))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[f s & r] deck]
    (vec (cons s (cons f r)))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[f & rem] deck]
    [f rem]))

(def face-cards
  ["jack" "queen" "king"])


(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[head & tail] deck]
    (vec (remove nil? (flatten [head face-cards tail])))))

 

