(ns labs.destruct-map-reduce-thread-last)
(def demand {:backpack {:quantity 4 :price 80}
             :t-shirt {:quantity 5 :price 40}})

(defn print-15 [value]
  (println value) 15)

(println (map print-15 demand))                             ;returns a map entry within key value


; destruct array in clojure:
(defn print-15 [[key value]]
  (println key "and" value) 15)

(println (map print-15 demand))

(defn price-of-products [[_ value]]                                  ;if you don't need a value, just pass a _ in params
(* (:quantity value) (:price value)))

(defn total [demand]
  (reduce + (map price-of-products demand)))

(println (total demand))

;Thread Last
(defn price-of-products [value]
  (* (:quantity value) (:price value)))

(defn total [demand]
  (->> demand
        vals
        (map price-of-products)
        (reduce +)))

(println (total demand))

;with lambda
(defn total [demand]
  (->> demand
       vals
       (map #(* (:quantity %) (:price %)))
       (reduce +)))

(println (total demand))