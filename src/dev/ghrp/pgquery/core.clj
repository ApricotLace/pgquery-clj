(ns dev.ghrp.pgquery.core
  (:import (dev.ghrp.pgquery PgQueryWrapper)))

(defn parse-sql ^#_"JSON"String [^String sql]
  (let [wrapper (PgQueryWrapper.)]
    (.parseSQL wrapper sql)))

(comment
  ;; Usage example
  (parse-sql "SELECT 1")

  )
