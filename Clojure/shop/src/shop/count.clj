(ns shop.count)
;["dylan" "inae" "leandro" "marcos"]
(defn count [total elements]
  (recur (inc total) (rest elements)))

(println (count 0 ["dylan" "inae" "leandro" "marcos"]))

(defn count [total elements]
  (if (next elements)
    (recur (inc total) (next elements))
    total))                                                 ;returns 1 less element


(defn count [total elements]
  (if (seq elements)
    (recur (inc total) (next elements))
    total))                                                 ;correct way

;like polimorfism (overcharge in c#), varying the arity
(defn count
  ([elements]
   (count 0 elements))

  ([total elements]
   (if (seq elements)
     (recur (inc total) (next elements))
     total)))

(println (count ["dylan" "inae" "leandro" "marcos"]))
(println (count []))

;