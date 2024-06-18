(ns dev.ghrp.pgquery.core
  (:import (dev.ghrp.pgquery PgQueryWrapper)))

(defn parse-sql [sql]
  (let [wrapper (PgQueryWrapper.)]
    (.parseSQL wrapper sql)))
