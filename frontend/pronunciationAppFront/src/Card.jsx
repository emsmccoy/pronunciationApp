import { getImageUrl } from './utils.js';


export default function Card(){


return (
  <>
    <h1>Notable Scientists</h1>
    <section className="profile">
      <h2>Maria Skłodowska-Curie</h2>
      <img
        className="avatar"
        src={getImageUrl("szV5sdG")}
        alt="Maria Skłodowska-Curie"
        width={70}
        height={70}
      />
      <ul>
        <li>
          <b>Profession: </b>
          physicist and chemist
        </li>
        <li>
          <b>Awards: 4 </b>
          (Nobel Prize in Physics, Nobel Prize in Chemistry, Davy Medal,
          Matteucci Medal)
        </li>
        <li>
          <b>Discovered: </b>
          polonium (chemical element)
        </li>
      </ul>
    </section>
  </>
);


}