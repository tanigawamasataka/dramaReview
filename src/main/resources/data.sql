/*ユーザーマスタのデータ(アドミン権限)*/
INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('yamada@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '山田太郎', '1990-01-01', true, 'ROLE_ADMIN',false);

/*ユーザーマスタのデータ(一般権限)*/
INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('sato@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '佐藤太郎', '1995-03-10', true, 'ROLE_GENERAL',false);

INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('hanako@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '山田花子', '1984-03-01', false, 'ROLE_GENERAL',false);

INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('suzuki@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '鈴木一郎', '1998-05-29', true, 'ROLE_GENERAL',false);

INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('tanaka@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '田中夏子', '2001-08-14', false, 'ROLE_GENERAL',false);

INSERT INTO user(user_id, password, user_name, birthday, gender, role, deleted)
VALUES('watanabe@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '渡部あき', '2005-10-10', false, 'ROLE_GENERAL',false);


/*ドラマ情報マスタのデータ*/
INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('hanzawanaoki.jpg', '半沢直樹','バブル期入行世代の葛藤と苦悩に満ちた戦いを鮮やかに描き出す。基本は性善説。ただしやられたら倍返し！型破りのバンカー、半沢直樹伝説の始まりだ！
バブル期、都市銀行の数は全部で13行。銀行に入ったら一生安泰と言われていた時代で、銀行員はエリートの代名詞でもあった。
いわゆる「バブル入行組」の半沢直樹が、銀行の内外に現れる「敵」と戦い、組織と格闘していく様子を中心に描いていきます。','堺雅人','2020-07-19');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('watanagi.jpg', '私の家政婦ナギサさん','働き盛りで仕事に一直線で､家事と恋には不器用な28歳の独身女性が､おじさん家政夫を雇うことから巻き起こるハートフルラブコメディー｡
仕事だけでなく恋も婚活も頑張り､いっぱいいっぱいになる主人公･相原メイを､多部が表情豊かに明るくポップに演じる｡仕事だけでなく恋も婚活も頑張り､いっぱいいっぱいになる
主人公･相原メイを､多部が表情豊かに明るくポップに演じる｡そんなメイの生活に安らぎと潤いを与える家政夫･鴫野ナギサを演じるのは大森南朋｡大森の渋くてハードボイルドな
イメージからは想像できない､エプロン姿で家事をするおじさん家政夫というギャップのある役どころも本作の見どころのひとつ｡
そして､メイの仕事のライバルとなる､爽やかで一見非の打ち所がない田所優太を､瀬戸康史がカッコよくかつ魅力的に演じる｡'
,'多部未華子','2020-07-07');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('hakennohinkaku.jpg', 'ハケンの品格','今や日本では300万人に迫るという“派遣社員”。彼（彼女）らなくして現代の企業は成り立たないと言っていいかもしれない。
そんな時代に現れた超人的なスキルをもった“スーパーハケン”を主人公としたドラマ『ハケンの品格』が、好評を博した。'
,'篠原涼子','2020-06-17');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('watadou.jpg', '私たちはどうかしている','15年前。老舗和菓子屋・光月庵の若旦那が何者かに殺害された。
そして、彼の息子の証言から、住み込みで働いていた女性職人が容疑者として逮捕される。
互いに初恋の相手だったはずの七桜（なお）と椿（つばき）は、容疑者の娘と被害者の息子となり、憎み合ったまま離ればなれに…。
そして、15年の時を経て、二人は運命の再会を果たす。
椿は、七桜を幼なじみと気づかぬまま、 再会したその日にプロポーズ!
母の無実を証明するため、正体を隠したまま“偽りの結婚”を利用して、光月庵に乗り込む七桜！
しかし、そこには、結婚に反対する女将の執拗な嫌がらせやドロドロのお家事情など、様々な逆境が待ち受けていて…！？'
,'横浜流星','2020-08-12');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('BGPersonalGuard.jpg','BG身辺警護人','“BG＝ボディーガード” 「武器を持たず、人を護る民間の警護人」 日本において、警護する職業として一般的によく知られているSP（セキュリティーポリス）。
 木村拓哉演じる民間警備会社のボディーガード・島崎章は、過去のある出来事をきっかけにボディーガードの世界からは身を引き、工事現場の警備員に。
しかし身辺警護課の新設を機に復帰を決意。みずからのキャリアを隠し、イチ“新人ボディーガード”として身辺警護課に着任します。そこには章と同じように、さまざまな過去を抱えた男女が…。'
,'木村拓哉','2020-06-18');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('UnsungCinderella.jpg', 'アンサング・シンデレラ','葵みどり（石原さとみ）は萬津総合病院薬剤部で働くキャリア８年目の病院薬剤師。
同じ薬剤部の刈谷奈緒子（かりや・なおこ／桜井ユキ）の指示のもと、羽倉龍之介（はくら・りゅうのすけ／井之脇海）や工藤虹子（くどう・にじこ／金澤美穂）ら
病院薬剤師たちが、山のように舞い込んだ処方箋をひとつひとつ確認し、調剤、監査といった膨大な作業量をスピーディーにこなしていく。
ある日、そんな薬剤部に新人の相原（あいはら）くるみ（西野七瀬）がやってくる。
「向いてなかったら辞めようと思ってます」ときっぱり言い切るくるみだったが、救急センターで医師や看護師と連携して緊急処置に当たる病院薬剤師・瀬野章吾（田中圭）とみどりの姿を目の当たりにして…'
,'石原さとみ','2020-07-16');

INSERT INTO drama_info(drama_image, drama_name, drama_story, lead_actor, release_date)
VALUES('Suits2.jpg', 'SUITSスーツ2','ある日、甲斐（織田裕二）と大輔（中島裕翔）は、有名キャスターの浜崎哲平（中村芝翫）に会いに行く。浜崎は、自身のテレビ番組で人気プロ野球選手・等々力真一（佳久創）の薬物使用疑惑を報じて訴えられていた。
等々力の所属球団は、浜崎と番組を放送した『東都テレビ』に対して、それぞれ賠償金3億円と、番組での公式謝罪を要求していた。浜崎は、これまでも社会のタブーに踏み込み、何度もトラブルを起こしていた。
だが今回は、相手側が日本経済のドンが球団親会社のトップということもあって、謝罪するしかないのでは、と考える甲斐と大輔。
しかし浜崎はそれを頑なに拒む。そして『幸村・上杉法律事務所』のトップは、チカ（鈴木保奈美）か、それとも上杉（吉田鋼太郎）か。シニアパートナーによる投票で代表を決める会議が5日後に迫っていた……。'
,'織田裕二','2020-04-13');

/*レビューマスタのデータ*/
INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('これは現代の歌舞伎!?', '今回もむちゃくちゃで面白い。コント度と歌舞伎度マシマシ。顔芸と名言に溢れております。ただ、こんな酷い会社アウトだわ。笑', '80','山田太郎', '1');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('豪華俳優陣による全力の『大人の悪ふざけ』', '幼少の頃に観た『ビーストウォーズメタルス』の声優全員による全力の悪ふざけが大好きだったのですが、あれを思い出しますね。', '80','佐藤太郎', '1');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('可愛くてほっこりするドラマ！', '主人公は一生懸命なんだけど暗さや圧迫感を視聴者に与えない適度な軽さが多部ちゃんの持ち味になっててストレスフリー。お仕事系ドラマかと思いきや、実は？ナギサさんに無意識に興味津々になる演技が上手いし、笑える。後半も期待で視聴中', '100','山田花子', '2');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('めちゃくちゃスカッとするドラマ', '大前春子は言いたくても言えない、思ってても言えないことをズバッと！代弁してくれる。そんな誰もが憧れを抱くキャラなのである。', '80','鈴木一郎', '3');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('漫画も見てたけど、原作の世界観のまま！', '横浜流星、好きじゃなかったのに、めちゃくちゃかっこよくてニヤけながら見てる。観月ありさも役にはまってるわ。', '60','田中夏子', '4');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('今期イチオシドラマ。','石原さとみちゃん主演の病院薬剤師さんのお話。薬剤オタクで薬の味見をする葵さん好き(笑)電話帳変態で登録されてて笑いました。', '60','渡部あき', '6');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('2話しびれた…。', '甲斐、なんという男だろう。完全なWin-Winに持っていったぜよ…って、プロット出来てたから織田裕二の演技力、かな？', '100','山田太郎', '7');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('日本版SUITSセカンドシーズン。', '相変わらずスタイリッシュな感じと変わらないキャストで引き続き楽しめそうなスタート', '80','鈴木一郎', '7');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('season1の時から思ってたけど…', 'アメリカンジョークを日本語で言うセリフがやっぱりダサい…けど織田裕二だからギリギリ許せてる（笑）', '60','佐藤太郎', '7');

INSERT INTO drama_review(review_title, review_text, evaluation, user_name, drama_id)
VALUES('アメリカ版と比べると、やっぱり違和感が…', 'シーズン1が面白かった記憶で、2を見始めたが、アメリカドラマのリメイクとは言え、アメリカナイズしたような台詞はどうなんだろ？織田裕二と鈴木保奈美の会話がどんどん気取っていき鼻につく。
突然マカオ行ったり、豪華な様で話あちこち飛んで視聴者置いてきぼりだよ。本当なら、甲斐が追い詰められて行き面白くなる話なんだろうに、残念ながら、面白く無い。
中島裕翔はシーズン1良かったのに今回どうと言うことないし。', '20','田中夏子', '7');