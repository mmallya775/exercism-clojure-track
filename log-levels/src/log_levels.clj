(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (let [m (str s)
        split-along (str/split m #":")
        strip-spaces (str/trim (second split-along))]
    strip-spaces))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [m (str s)
        split-along (str/split m #":")
        strip-spaces (str/trim (first split-along))
        clean-level (str/replace strip-spaces #"[\[\]]" "")]
    (str/lower-case clean-level)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))

(reformat "[ERROR]: Invalid operation")