(ns shop.map-schema
  :require [shop.db :as s.db])

(println (l.db/all-demands))

(println (group-by :user (l.db/all-demands)))

(println (map count (vals (group-by :user (l.db/all-demands)))))

(->> (l.db/all-demands)
     (group-by :user)
     vals
     (map count)
     println)

(defn total-per-user [[user demands]]
  {:user-id user
   :total (count demands)})

(->> (l.db/all-demands)
     (group-by :user)
     (map total-per-user)
     println)



(defn total-of-demands [demands]
    (->> demands
         (map :itens)
         (map total-of-demand)))

(defn total-price-and-total-per-user [[user demands]]
  {:user-id user
   :total (count demands)
   :total-price (total-of-demands demands)})

(->> (l.db/all-demands)
     (group-by :user)
     (map total-price-and-total-per-user)
     println)