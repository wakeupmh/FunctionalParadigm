(ns shop.map-schema
  :require [loja.db :as l.db])

(println (l.db/all-demands))

(println (group-by :user (l.db/all-demands)))
