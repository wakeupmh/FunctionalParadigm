(ns shop.map-schema
  :require [loja.db :as l.db])

(println (l.db/all-demands))

(println (group-by :user (l.db/all-demands)))

(println (map count (vals (group-by :user (l.db/all-demands)))))

(->> (l.db/all-demands)
     (group-by :user)
     vals
     (map count)
     println)

(defn total-per-user [[user demands]]
  {
    :user (count demands)
    :total ()
   }
  )

(->> (l.db/all-demands)
     (group-by :user)
     (map total-per-user)
     println)